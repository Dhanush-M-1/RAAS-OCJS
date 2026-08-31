#include<bits/stdc++.h>
#define ll long long

using namespace std;

int main(){
	ll n, i, j, mini, z;
	
	cin>>n;
	
	vector < ll > a(n+1);
	
	for(i=0; i<n; i++){
		cin>>a[i];
	} 
	
	z=0;
	for(i=0; i<n; i++){
		mini=i;
		for(j=i; j<n; j++){
			if(a[j]<a[mini]){
				mini=j;
			}
		}
		swap(a[i],a[mini]);
		if(i!=mini) z++;
	}
	
	for(i=0; i<n-1; i++){
		cout<<a[i]<<" ";
	}
	cout<<a[n-1]<<"\n";
	cout<<z<<"\n";
	
	return 0;
}
