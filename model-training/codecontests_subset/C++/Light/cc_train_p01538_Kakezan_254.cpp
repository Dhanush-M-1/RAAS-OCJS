#include<iostream>
#include<cmath>
#define loop(i,a,b) for(int i=a;i<b;i++)
#define rep(i,a) loop(i,0,a)
using namespace std;

int fnc(int n){
	if(n<10)return 0;
	int ans=0;
	for(int i=1;(int)pow(10,i)<n;i++){
		int pre=n/(int)pow(10,i),la=n%((int)pow(10,i));
		ans=max(ans,pre*la);
	}
	return fnc(ans)+1;
}

int main(){
	int q;
	cin>>q;
	int num;
	rep(p,q){
		cin>>num;
		cout<<fnc(num)<<endl;
	}
	return 0;
}