terraform {
  backend "s3" {
    bucket = "terraform-class-backend-arman-bucket"
    key    = "jenkins-class/app-infra/terraform.tfstate"
    region = "us-east-1"
  }
}