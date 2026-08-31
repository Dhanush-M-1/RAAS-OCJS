#include <iostream>
#include <cstdlib>
#include <algorithm>
#include <cmath>
#include <vector>
#include <set>
#include <map>
#include <unordered_set>
#include <unordered_map>
#include <queue>
#include <ctime>
#include <cassert>
#include <complex>
#include <string>
#include <cstring>
#include <chrono>
#include <random>
#include <bitset>
#include <limits>
#include <numeric>

using namespace std;

const int MOD = 1e9 + 7;

struct matrix {
	

    int size = 10;
    int a[10][10];
	
    matrix() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                a[i][j] = 0;
            }
        }
    }
	
	matrix operator *(matrix& other) {
		matrix product;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				for (int k = 0; k < size; k++) {
					product.a[i][k] += a[i][j] * other.a[j][k] % MOD;
					product.a[i][k] %= MOD;
				}
			}
		}
		return product;
	}
	
};

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	
    vector<matrix> m(200001);
    matrix trans;
    trans.a[0][9] = 1;
    trans.a[1][9] = 1;
    for (int i = 1; i <= 9; i++) {
        trans.a[i][i - 1] = 1;
    }
    for (int i = 0; i <= 9; i++) {
        m[0].a[i][i] = 1;
    }
    for (int i = 1; i <= 200000; i++) {
        m[i] = trans * m[i - 1];
    }
	
	int tt;
	cin >> tt;
	while (tt--) {
        string s;
        int k;
        cin >> s >> k;
        int cnt[10];
        for (int i = 0; i < 10; i++) {
            cnt[i] = 0;
        }
        for (char c : s) {
            cnt[c - '0']++;
        }
        long long answer = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                answer = (answer + (long long)m[k].a[i][j] * cnt[j]) % MOD;
            }
        }
        cout << answer << '\n';
	}
}
