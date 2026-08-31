#include<bits/stdc++.h>
using namespace std;
int a[2];
int main(){
	cin>>a[0]>>a[1]>>a[2];
	sort(a,a+3);
	if(a[0]+a[1]==a[2]) cout<<"Yes";
	else cout<<"No";}