#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

int q,r;
int n;
int nmax;
int b;

void calc(){
	if(n/10==0)return;
	r++;
	int keta=0;
	b=0;
	for (int i = n; i > 0; i/=10){
		keta++;
	}
	for(int i=0; i<keta; i++){
		int x,y;
		int k=10;
		for (int j = 0; j < i; ++j){
			k*=10;
		}
		x=n/k;
		y=n%k;
		if(!b){
			nmax=x*y;
			b=1;
		}
		else{
			if(nmax<x*y){
				nmax=x*y;
			}
		}
	}
	n=nmax;
	//cout<<"n:"<<n<<endl;
	calc();
}

int main(){
	cin>>q;
	for (int i = 0; i < q; ++i){
		cin>>n;
		r=0;
		calc();
		cout<<r<<endl;
	}
}