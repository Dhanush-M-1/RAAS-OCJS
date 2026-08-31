#include<iostream>
using namespace std;
int selectionSort(int *num,int n){
	int minn,ans=0;
	for(int i=0;i<n-1;i++){
		minn=i;
		for(int j=i;j<n;j++){
			if(num[j]<num[minn]) minn=j;
		}
		swap(num[i],num[minn]);
		if(i!=minn) ans++;
	}
	return ans;
}
int main(){
	int num[110];
	int n;
	while(cin>>n){
		for(int i=0;i<n;i++) cin>>num[i];
		int ans=selectionSort(num,n);
		for(int i=0;i<n;i++){
			if(i) cout<<' ';
			cout<<num[i];
		}
		cout<<endl<<ans<<endl;
	}
}