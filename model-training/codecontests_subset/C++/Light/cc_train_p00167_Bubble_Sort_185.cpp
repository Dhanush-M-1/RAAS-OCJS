#include<iostream>
#include<algorithm>
using namespace std;


int inversion(int a[],int n){
	int cnt=0;
	for(int i=n-1;i>0;i--){
		for(int j=0;j<i;j++){
			if(a[j]>a[j+1]){
				swap(a[j],a[j+1]);
				cnt++;
			}
		}
	}
	return cnt;
}

int main(){
	int a[100],n;
	while(cin>>n&&n){
		for(int i=0;i<n;i++){
			cin>>a[i];
		}
		cout<<inversion(a,n)<<endl;
	}
	return 0;
}