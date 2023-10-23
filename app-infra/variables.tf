variable "ami" {
  default     = "ami-053b0d53c279acc90"
  type        = string
}

variable "instance_type" {
  default     = "t2.micro"
  type        = string
}

variable "key_name" {
  default     = "Arman@windows"
  type        = string
}

variable "az" {
  default = "us-east-1a"
  type = string
}

variable "tag_name1" {
  default = "Test-instance"
  type = string
}

variable "tag_purpose1" {
  default = "jenkins-class"
  type = string
}

variable "tag_env1" {
  default = "test"
  type = string
}

variable "tag_name2" {
  default = "test-bucket"
  type = string
}

variable "tag_purpose2" {
  default = "jenkins-class"
  type = string
}

variable "tag_env2" {
  default = "test"
  type = string
}

variable "bucket_name" {
  default = "jenkins-class-arman-test-bucket-01"
  type = string
}