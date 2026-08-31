#include<iostream>
#include<cstdio>
#include<algorithm>
using namespace std;
#define MAX 110
int main(){
	int n;
	int list[MAX];
	while(cin>>n,n){
		int ans=0;
		for(int i=0;i<n;i++){
			cin>>list[i];
		}
		
		
		for(int i=0;i<n;i++){
			for(int j=0;j<n-i-1;j++){
				if(list[j]>list[j+1]){
					swap(list[j],list[j+1]);
					ans++;
				}
			}
		}
		
		
		
		
		cout<<ans<<endl;
	}
	return 0;
}