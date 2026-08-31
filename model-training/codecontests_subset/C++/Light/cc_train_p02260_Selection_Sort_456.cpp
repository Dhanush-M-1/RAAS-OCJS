#include <iostream>
using namespace std;

int main() {	
	int a[105];
	int n;
	cin>>n;
	for(int i=0;i<n;i++){
		cin>>a[i];
	}
	int count=0;
	for(int i=0;i<n-1;i++){
		int minj=i;
		for(int j=i+1;j<n;j++){
			if(a[minj]>a[j]){
				minj=j;
			}
		}
		if(minj!=i){
			int temp = a[minj];
			a[minj]=a[i];
			a[i]=temp;
			count++;
		}
	}
	
	for(int i=0;i<n;i++){
		if(i>0) cout<<" ";
		cout<<a[i];
	}
	cout<<endl;
	cout<<count<<endl;
	
	return 0;
}