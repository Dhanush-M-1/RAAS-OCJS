#include<iostream>
using namespace std;

int main(){
	int n,a[100];
	int exchanges=0;
	
	cin>>n;
	for(int i=0;i<n;i++){
		cin>>a[i];
	}
	
	for(int i=0;i<n;i++){
		int minIndex = i;
		for(int j=i;j<n;j++){
			if(a[j]<a[minIndex]){
				minIndex=j;
			}
		}
		if(minIndex!=i){
			int tmp;
			tmp=a[i];
			a[i]=a[minIndex];
			a[minIndex]=tmp;
			exchanges++;
		}
	}
	for(int i=0;i<n;i++){
		if(i>0) cout<<" ";
		cout<<a[i];
	}
	cout<<endl;
	cout<<exchanges<<endl;
}