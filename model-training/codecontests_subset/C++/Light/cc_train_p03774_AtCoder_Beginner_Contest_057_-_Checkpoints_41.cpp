#include <bits/stdc++.h>
using namespace std;

int N,M,a[59],b[59],c[59],d[59];

int main(){
	cin>>N>>M;
	for(int i=1;i<=N;i++) cin>>a[i]>>b[i];
	for(int j=1;j<=M;j++) cin>>c[j]>>d[j];
	for(int i=1;i<=N;i++){
		int minx=1000000000,maxid=0;
		for(int j=1;j<=M;j++){
			int sum=abs(a[i]-c[j])+abs(b[i]-d[j]);
			if(minx>sum){minx=sum;maxid=j;}
		}
		cout<<maxid<<endl;
	}
	return 0;
}
