#include <iostream>
#include <string>

int N;

using namespace std;

void dfs(string s, char mx) {
	if (s.length()==N) cout << s << endl;
  	else {
    	for (char i='a'; i<=mx; i++) {
        	if (i==mx) dfs(s+i, mx+1);
          	else dfs(s+i, mx);
        }
    }
}

int main() {
  	cin >> N;
  	dfs("", 'a');
	return 0;
}
