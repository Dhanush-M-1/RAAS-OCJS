#include <bits/stdc++.h>
using namespace std;

long long gc(long long a,long long b){
	if(a<=b) swap(a,b);
	if(a%b==0) return b;
	else return gc(b,a%b);
}

int main() {
  int T;
  cin>>T;
  int i,j;
  long long a,b,c,d;
  for(i=0;i<T;i++){
	cin>>a>>b>>c>>d;
	if(b>d) cout<<"No"<<endl;
	else if(b>a) cout<<"No"<<endl;
	else{
		long long e=gc(b,d);
		long long f=(a-c)/e;
		f-=1;
		long long k=a-e*f;
		if(k-e>c) k-=e;
		if(k<b) cout<<"No"<<endl;
		else cout<<"Yes"<<endl;
 	
	}
  }
  return 0;
}     
