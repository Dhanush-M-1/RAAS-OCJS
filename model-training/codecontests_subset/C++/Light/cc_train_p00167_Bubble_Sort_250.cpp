#include <iostream>
using namespace std;

int main(void){
	int n;
	while(cin>>n,n){
		int t[n];
		for(int i=0;i<n;i++){
			cin>>t[i];
		}
		if(n == 1){
			cout<<0<<endl;
			continue;
		}
		int ans = 0;
		for(int i=0;i<n;i++){
			for(int j=0;j<n-1;j++){
				if(t[j] > t[j+1]){
					ans++;
					swap(t[j],t[j+1]);
				}
			}
		}
		cout<<ans<<endl;
	}

	return 0;
}