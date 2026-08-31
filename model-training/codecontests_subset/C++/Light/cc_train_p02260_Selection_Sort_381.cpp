#include<bits/stdc++.h>
using namespace std;
int main(void){
	int n;
	array<int,100>ar;
	int i,j;
	int cnt;
	int x;
	cin>>n;
	for(i=0;i<n;i++)	cin>>ar[i];
	for(i=0;i<n-1;i++){
		x=i;
		for(j=i;j<n;j++){
			if(ar[j]<ar[x])	x=j;
		}
		swap(ar[i],ar[x]);
		if(i!=x)	cnt++;
	}
	cout<<ar[0];
	for(i=1;i<n;i++)	cout<<" "<<ar[i];
	cout<<endl;
	cout<<cnt<<endl;
	return 0;
}
