#include <bits/stdc++.h>
using namespace std;
typedef long long LL;

int main(){
	int n,A,ans=0;
	vector<int> a;
	cin>>n;
	for(int i=0;i<n;i++){
		cin>>A;
		a.push_back(A);
	}
	for(int i=0;i<n;i++){
		int minj=i;
		for(int j=i;j<n;j++) if(a[j]<a[minj]) minj=j;
		if(a[i]!=a[minj]){
			A=a[i];
			a[i]=a[minj];
			a[minj]=A;
			ans++;
		}
	}
	for(int i=0;i<n;i++){
		if(i==n-1) cout<<a[i]<<endl<<ans<<endl;
		else cout<<a[i]<<" ";
	}
	return 0;
}

