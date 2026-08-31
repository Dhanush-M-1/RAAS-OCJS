#include<iostream>
#include<algorithm>
#define INF 210000
using namespace std;
int c[INF];
int main(){
	int n,a,b;
	for(int i=0;i<INF;i++)c[i]=0;
	cin>>n;
	for(int i=0;i<n;i++){
		cin>>a>>b;
		c[a+b]++;
	}
	for(int i=0;i<INF-1;i++){
		c[i+1]+=c[i]/2;
		if(c[i]%2)cout<<i<<" 0"<<endl;
	}
	return 0;
}