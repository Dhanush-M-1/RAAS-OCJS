#include <iostream>
#include <algorithm>
using namespace std;

int selectionSort(int a[],int n){
	int i,j,sw=0,minj;
	for(i=0;i<n-1;++i){
		minj=i;
		for(j=i;j<n;++j)
			if(a[j]<a[minj]) minj=j;
		swap(a[i],a[minj]);
		if(i!=minj) ++sw;
	}
	return sw;
}

int main(){
	int n,a[100],i,sw;
	cin>>n;
	for(i=0;i<n;++i) cin>>a[i];
	sw=selectionSort(a,n);
	for(i=0;i<n;++i){
		if(i>0) cout<<" ";
		cout<<a[i];
	}
	cout<<endl<<sw<<endl;
	return 0;
}
