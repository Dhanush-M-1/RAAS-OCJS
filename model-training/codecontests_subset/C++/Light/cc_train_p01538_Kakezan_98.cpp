#include <iostream>
#include <math.h>
#include <algorithm>
using namespace std;
int main(){
	int q,n;
	cin>>q;
	for(int i=0;i<q;i++){
		cin>>n;
		int ct=0,keta=1;
		while(n>9){
			for(int k=6;k>=1;k--){
				if(n/pow(10,k)>=1){
					keta=k;
					break;
				}
			}
			int ma=0;
			for(int j=1;j<=keta;j++){
				int a=pow(10,j);
				ma=max(ma,(n/a)*(n%a));
			}
			if(n==ma){
				ct=-1;
				break;
			}
			n=ma;
			ct++;
		}
		cout<<ct<<endl;
	}
    return 0;
}