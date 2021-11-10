#!/bin/zsh
LINK=$1
BRANCH_1=$2
BRANCH_2=$3

echo $LINK
echo $BRANCH_1
echo $BRANCH_2

# python -c "
# import sys
# s = sys.argv[1]
# print(s.split('github.com')[1].split('.git')[0].split('/')[-1])
# " $LINK >> name.txt

echo $name
mkdir "./temp/"
cd "temp"
git clone $LINK --branch $BRANCH_1 repo
cd repo
git fetch origin
git checkout -b origin/$BRANCH_2
git pull origin $BRANCH_2
git diff origin/$BRANCH_2 $BRANCH_1 >> '../../log.txt'

cd ../..
rm -rf "temp/"
