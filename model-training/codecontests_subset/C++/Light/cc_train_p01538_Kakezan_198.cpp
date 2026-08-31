#include<iostream>
#include<set>
#include<algorithm>
using namespace std;

int main(){
	int q;
	cin>>q;
	while(q--){
		int n;
		set<int> s;
		cin>>n;
		int ans=0;
		while(10<=n){
			if(s.find(n)!=s.end()){
				ans=-1;
				break;
			}
			s.insert(n);
			int next=0;
			int b=10;
			while(b<=n){
				int t=(n%b)*(n/b);
				next=max(next,t);
				b*=10;
			}
			n=next;
			ans++;
		}
		cout<<ans<<endl;
	}
	return 0;
}