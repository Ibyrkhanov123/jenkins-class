resource "aws_instance" "test_instance" {
  ami               = var.ami
  instance_type     = var.instance_type
  key_name          = var.key_name
  availability_zone = var.az
  tags = merge(
    local.common_tags,
    {
    Name    = "${var.tag_name1}"
    Purpose = "${var.tag_purpose1}"
    Env     = "${var.tag_env1}"
    }
  )
}

resource "aws_s3_bucket" "test_bucket" {
  bucket = var.bucket_name
  tags = merge(
    local.common_tags,
    {
    Name    = "${var.tag_name2}"
    Purpose = "${var.tag_purpose2}"
    Env     = "${var.tag_env2}"
    }
  )
}