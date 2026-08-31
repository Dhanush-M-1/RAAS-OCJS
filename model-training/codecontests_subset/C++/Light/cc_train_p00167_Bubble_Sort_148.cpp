#include<bits/stdc++.h>
using namespace std;

int main(){
	int n;
	while(cin>>n,n){
		int data[114];
		for(int i=0;i<n;i++)cin>>data[i];
		int ans=0;
		while(1){
			int flg=1;
			for(int i=0;i<n-1;i++){
				if(data[i]>data[i+1])flg=0;
				}
			if(flg)break;
			
			for(int i=0;i<n-1;i++){
				if(data[i]>data[i+1]){
					swap(data[i],data[i+1]);
					ans++;
					}
				}	
			}
			cout<<ans<<endl;
		}
		return 0;
	}