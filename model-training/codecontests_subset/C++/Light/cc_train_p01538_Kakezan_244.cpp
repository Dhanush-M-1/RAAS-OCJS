#include<iostream>
#include<vector>
#include<queue>
using namespace std;
int f(int r,int t,int r2){
	if(r<10){
		return t;
	}else if(t>r2){
		return -1;
		}else{
		priority_queue<int> a;
		int keta=10;
		while(r>keta){
			int b=r/keta,c=r%keta;
			a.push(b*c);
			keta*=10;
		}
		return f(a.top(),t+1,r2);
	}
}
int main(void){
int n;
cin>>n;
for(int k=0;k<n;k++){
int r;
cin>>r;

cout<<f(r,0,r)<<endl;
}

	return 0;
}