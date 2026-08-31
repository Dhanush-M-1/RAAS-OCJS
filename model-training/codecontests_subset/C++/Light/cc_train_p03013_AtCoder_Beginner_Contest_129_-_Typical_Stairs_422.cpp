#include<iostream>
using namespace std;

int s[100005];


int main(){
	int n,m,tmp;
	long long f[100006];
	cin>>n>>m;
	for(int i=1;i<=m;++i){
		cin>>tmp;
		s[tmp]=1;
	}
	f[1]=1;f[0]=1;
	if(s[1]==1)	f[1]=0;
	for(int i=2;i<=n;++i){
		if(s[i]==1)	f[i]=0;
		else		f[i]=(f[i-1]+f[i-2])%1000000007;
	}
	cout<<f[n];
}