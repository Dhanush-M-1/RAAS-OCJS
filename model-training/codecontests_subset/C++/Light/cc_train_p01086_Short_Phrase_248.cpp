#include <iostream>
#include <vector>
#include <algorithm>
#include <map>
#include <string>
#include <cstring>
using namespace std;
typedef long long int ll;

int n;
int p[]={5,12,17,24,31};

void solve(){
	vector<int> a(n+1);
	for(int i=0;i<n;i++){
		string s; cin >> s;
		a[i+1]=a[i]+(int)s.size();
	}
	for(int i=0;i<n;i++){
		int j=0;
		for(int k=i+1;k<=n;k++){
			if(a[k]==a[i]+p[j]){
				j++;
				if(j==5)break;
			}
		}
		if(j==5){
			printf("%d\n",i+1 );
			return;
		}
	}
}

int main(){
	cin.tie(0);
	ios::sync_with_stdio(false);
	while(1){
		cin >> n;
		if(n==0)break;
		solve();
	}
}
