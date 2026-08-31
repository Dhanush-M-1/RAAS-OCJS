#include<bits/stdc++.h>
#define MAXN
using namespace std;
map <string,int> m;
int main() {
	int n; scanf("%d",&n);
	for(int i = 1;i <= n;i ++) {
		string s; cin >> s;
		m[s] ++;
	}
	printf("AC x %d\n",m["AC"]);
	printf("WA x %d\n",m["WA"]);
	printf("TLE x %d\n",m["TLE"]);
	printf("RE x %d\n",m["RE"]);
	return 0;
}
