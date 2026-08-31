#include <iostream>
#include <string.h>
using namespace std;
//BIT
long bit[1000001],n;
long MAX;
long sum(int i){
	long s=0;
	while(i>0){
		s+=bit[i];
		i-=i&-i;
	}
	return s;
}
void add(long i,long x){
	while(i<=MAX){
		bit[i]+=x;
		i+=i&-i;
	}
}
long a[100];
bool input(){
	cin >> n; if(!n) return false;
	for(int i=0;i<n;i++) cin >> a[i];
	MAX=a[0];
	for(int i=0;i<n;i++) MAX=max(MAX,a[i]);
	return true;
}
int main() {
	while(input()) {
		long long ans=0;
		for(int i=0;i<n;i++) {
			ans+=i-sum(a[i]);
			add(a[i],1);
		}
		cout << ans << '\n' ;
		memset(bit,0,sizeof(bit)); memset(a,0,sizeof(a));
	}
}