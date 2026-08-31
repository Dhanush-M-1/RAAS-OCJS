#include <bits/stdc++.h>
using namespace std;
#define lp(i,n) for(int i=0;i<n;i++)

int main(){
	int n;
	cin>>n;
	lp(z,n){
		int a,b=0,count=0;
		cin>>a;
		vector<int> lis;
		while(1){
			if(a/10==0) break;
			int i=1;
			while(1){
				if(a/10==0) break;
				b+=a%10*i;
				a/=10;
				lis.push_back(b*a);
				i*=10;
			}
			b=0;
			sort(lis.begin(),lis.end());
			reverse(lis.begin(),lis.end());
			a=lis[0];
			lis.clear();
			count++;
		}
		cout<<count<<endl;
	}
	return 0;
}
