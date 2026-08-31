#include<iostream>
using namespace std;

long long gcd(long long x,long long y){
	if(y==0)return x;
	return gcd(y,x%y);
}

int main(){
	ios::sync_with_stdio(0);
	long long n,a,b,c,d;
	cin>>n;
	for(int i=0;i<n;++i){
		cin>>a>>b>>c>>d;
		if(a<b||b>d){
			cout<<"No\n";
			continue;
		}
		if(b<=c+1){
			cout<<"Yes\n";
			continue;
		}
		long long g=gcd(b,d);
		if((a%g)+b-g>c)cout<<"No\n";
		else cout<<"Yes\n";
	}
	return 0;
}