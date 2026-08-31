#include <cmath>
#include <bits/stdc++.h>
#include <algorithm>
#include <iostream>
#include <vector>
#include <fstream>
#include <cassert>

using namespace std;


istream& inp = cin; 
//ifstream inp("in"); 

template<typename T>
vector<T> readV(int size) { 
	vector<T> result; 
	for (int i = 0; i < size; ++i) { T x; inp >> x; result.push_back(x); } 
	return result;
}

template<typename T>
T divup(T a, T b) { if ((a % b) == 0) return a / b; return 1 + a / b; } 


int64_t constexpr M = 1000000007;
static_assert( M <= (1 << 30));
class modint {
        int v;
  public:
        modint(int x) : v(x % M) {}
	modint() : v(0) {} 
        inline int get() const { return v; }
        modint operator + (modint b) { return modint(v + b.v); }


};

	vector<modint> len9(200010);
	string ns[200010];
	int ms[200010]; 


int32_t main() { 
	int ntests;
	assert(inp); 
	inp >> ntests;

	len9[0] =	modint(1);
	for (int i = 1; i <= 9; ++i) len9[i] = modint(2);
	len9[10] = modint(3);
	for (int i = 11; i < 200010; ++i) len9[i] = (len9.at(i - 9) + len9.at(i - 10));



	for (int test = 0; test < ntests; ++test ) {
		string n;
	       	int n0, m; 
		inp >> ns[test] >> ms[test];
	}

	for (int test = 0; test < ntests; ++test ) {
		string& n = ns[test];
		int m = ms[test];


		int64_t result = 0;
		assert(n.size() <= 11); 
		for (int i = 0; i < n.size(); ++i) {
			char c = n[i]; 
			assert(c >= '0' && c <= '9'); 
			int m1 = m - (int('9') - int(c));
			if (m1 <= 0) result = result + (1); else {
				result = result + len9[m1].get();
			}
		}

		cout << (result % M) << "\n"; 

	}


	return 0;
}
