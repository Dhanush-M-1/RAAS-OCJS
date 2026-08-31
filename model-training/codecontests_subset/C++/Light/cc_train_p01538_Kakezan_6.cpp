#include<iostream>
#include<math.h>
using namespace std;

int ans(int n){
	if(n/10==0)return 0;
	int ma=0;
	for(int i=0;i<=6;i++){
		int tmp=pow(10,i);
		ma=max(ma,(n/tmp)*(n%tmp));
	}
	return ans(ma)+1;
}

int main(){
	int q;
	cin>>q;
	for(int i=0;i<q;i++){
		int n;
		cin>>n;
		cout<<ans(n)<<endl;
	}
}