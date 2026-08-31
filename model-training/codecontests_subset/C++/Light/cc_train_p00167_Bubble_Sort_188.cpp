#include <algorithm>
#include <bitset>
#include <cstdio>
#include <cassert>
#include <cmath>
#include <functional>
#include <iostream>
#include <map>
#include <queue>
#include <set>
#include <tuple>
#include <utility>
#include <vector>
using namespace std;

bool solve() {
    int n, arr[100000];
    cin >> n;
    if (n == 0) { return false; }
    for (int j = 0; j < n; ++j) {
        cin >> arr[j];
    }
    int ret = 0;
    for (int j = 0; j < n; ++j) {
        for (int k = j+1; k < n; ++k) {
            if (arr[j] > arr[k]) {
                ++ret;
            }
        }
    }
    cout << ret << endl;
    return true;
}

int main() {
    while(solve());
    return 0;
}