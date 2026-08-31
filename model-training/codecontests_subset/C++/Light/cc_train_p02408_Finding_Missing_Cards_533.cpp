#include<iostream>
#include <stdio.h>
using namespace std;
int n,m,deck[4][14];
char s;
int main(){
	cin>>n;
	for(int i=0;i<n;i++){
	cin>>s>>m;
	if(s=='S'){
	deck[0][m]=1;}else
	if(s=='H'){
	deck[1][m]=1;}else
		if(s=='C'){
	deck[2][m]=1;}else{
		deck[3][m]=1;}}
	for(int i=0;i<4;i++){
	for(int ii=1;ii<14;ii++){
		if(deck[i][ii]<=0&&i==0){cout<<"S "<<ii<<endl;}else
	if(deck[i][ii]<=0&&i==1){cout<<"H "<<ii<<endl;}else
	if(deck[i][ii]<=0&&i==2){cout<<"C "<<ii<<endl;}else
	if(deck[i][ii]<=0){cout<<"D "<<ii<<endl;}}}
	return 0;}
