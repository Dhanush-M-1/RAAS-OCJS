#include <iostream>
#include <algorithm>
#include <map>
#include <set>
#include <queue>
#include <stack>
#include <numeric>
#include <bitset>
#include <cmath>

static const int MOD = 1000000007;
using ll = long long;
using u32 = unsigned;
using u64 = unsigned long long;
using namespace std;

template<class T> constexpr T INF = ::numeric_limits<T>::max()/32*15+208;

int main() {
    int n;
    cin >> n;
    vector<int> A(200100);
    for (int i = 0; i < n; ++i) {
        int a, b;
        cin >> a >> b;
        A[a+b]++;
    }
    for (int i = 0; i < 200099; ++i) {
        A[i+1] += A[i]/2;
        A[i] &= 1;
    }
    for (int i = 0; i < 200100; ++i) {
        if(A[i]) printf("%d %d\n", i, 0);
    }
    return 0;
}
