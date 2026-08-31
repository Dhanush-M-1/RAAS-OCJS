#include <bits/stdc++.h>
using namespace std;
 
int main() {
unordered_map<string,int> m;
int n; string a;
cin>>n; 
for(int i=0; i<n; ++i) {
	cin>>a; m[a]++;
}
		printf("AC x %d\nWA x %d\nTLE x %d\nRE x %d\n",m["AC"], m["WA"], m["TLE"], m["RE"]);


	return 0;
}
