#include <bits/stdc++.h>
using namespace std;

int n;

void dfs(string s, char mx) {
	if (s.length() == n) {
    	cout << s.c_str() << '\n'; 
    }
  	else {
    	for (char c = 'a'; c <= mx; ++c) {
        	dfs(s + c, ((c == mx) ? (char) (mx + 1) : mx)); 
        }
    }
}

int main() {
	cin >> n;
  	dfs("", 'a');
}