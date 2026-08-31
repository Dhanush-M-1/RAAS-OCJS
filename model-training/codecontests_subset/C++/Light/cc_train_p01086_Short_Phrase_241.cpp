#include<iostream>
#include<string>
#include<algorithm>
using namespace std;
int len[50];
int d[5]={5,7,5,7,7};
int main(){
	int n;
	string s;
	while(true){
	cin>>n;
	if(n==0)break;
	for(int i=0;i<n;i++){
		cin>>s;
		len[i]=s.size();
	}
	int ans=100000;
	for(int i=0;i<n;i++){
		int cnt=0;
		int set=0;
		int j=i;
		bool ok=true;
		while(true){
			cnt+=len[j];
			if(cnt==d[set]){
				cnt=0;
				set++;
				if(set==5)break;
			}
			if(cnt>d[set]){
				ok=false;
				break;
			}
			j++;
			if(j==n){
				ok=false;
				break;
			}
		}
		if(ok){
			ans=min(ans,i+1);
		}
	}
	cout<<ans<<endl;
	}
	return 0;
}