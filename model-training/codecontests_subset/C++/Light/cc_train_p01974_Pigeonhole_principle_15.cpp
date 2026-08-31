#include <iostream>
#include <fstream>
#include <string> 
#include <cmath>  
#include <cstdlib>
#include <ctime>
#include <vector>
#include <algorithm>
#include <numeric>
#include <map>
#include <set>
#include <stack>
#include <queue>
#include <deque>
#include <functional>
#include <cctype>

#define BIT(a) (1 << (a))

using namespace std;

long long MOD = 1000000007;


long long mod_pow(long long x, long long n){
    long long res = 1;
    for(int i = 0;i < 60; i++){
        if(n >> i & 1) res = res * x % MOD;
        x = x * x % MOD;
    }
    return res;
}

int amari[1000];

int main(void){
	int N;
	cin >> N;
	int a;
	int flag = 1;
	for (int i = 0; i < N; i++){
		cin >> a;
		if (amari[a%(N-1)] && flag){
			cout << amari[a%(N-1)] << " " << a << endl;
			flag = 0;
		}
		else amari[a%(N-1)] = a;
	}
	return 0;

}


