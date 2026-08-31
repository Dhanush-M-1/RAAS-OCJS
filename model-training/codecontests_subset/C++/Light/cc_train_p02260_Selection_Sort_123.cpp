#include <iostream>
using namespace std;
void swap(int* x,int* y){
	int tmp;
	tmp =*x; *x =*y; *y =tmp;
}
int main(){
	int n,sum=0;
	cin >>n;
	int x[n],minj;
	for(int i=0;i<n;i++) cin>>x[i];
	for(int i=0;i<n;i++){
		minj =i;
		for(int j=i;j<n;j++){
			if(x[j]<x[minj]) minj =j;
		}
		if(i != minj){
			swap(&x[i],&x[minj]); sum++;
		}
	}
	for(int i=0;i<n;i++){
		if(i==0) cout<<x[i];
		else cout<<" "<<x[i];
	}
	cout <<"\n"<<sum<<"\n";
}
