#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
typedef long long int ll;
 
int main(){
	cin.tie(nullptr);
	ios::sync_with_stdio(false);
	while(1){
		int n; cin >> n;
		if(n==0)break;
		int ans=0;
		int l=0,r=0;
		for(int i=0;i<n;i++){
			string s; cin >> s;
			if(s=="lu")l++;
			if(s=="ld")l--;
			if(s=="ru")r++;
			if(s=="rd")r--;
			r=min(1,r);
			l=min(1,l);
			r=max(0,r);
			l=max(0,l);
			if(ans%2==0&&l*r==1)ans++;
			else if(ans%2&&l==0&&r==0)ans++;
		}
		cout << ans << endl;
	}
}
