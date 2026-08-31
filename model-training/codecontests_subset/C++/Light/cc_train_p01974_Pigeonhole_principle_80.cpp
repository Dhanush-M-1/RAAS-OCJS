#include <cstdio>
#include <iostream>
#include <string>
#include <vector>
#include <sstream>
#include <map>
#include <set>
#include <queue>
#include <algorithm>
#include <cmath>
#include <cstdlib>
#include <cstring>
#include <typeinfo>
#include <numeric>
#include <functional>
#include <unordered_map>

using namespace std;
using ll = long long;
using ull = unsigned long long;

const ll INF = 1e9;
const ll MOD = 1e9 + 7;

#define REP(i, n) for(int i = 0; i < n; i++)


int main(){
    int n, a[1000];
    
    cin >> n;
    REP(i, n){
        cin >> a[i];
    }
    
    for(int i = 0; i < n - 1; i++){
        for(int j = i + 1; j < n; j++){
            if((max(a[i], a[j]) - min(a[i], a[j])) % (n - 1) == 0){
                cout << max(a[i], a[j]) << ' ' << min(a[i], a[j]) << endl;
                return 0;
            }
        }
    }
}

