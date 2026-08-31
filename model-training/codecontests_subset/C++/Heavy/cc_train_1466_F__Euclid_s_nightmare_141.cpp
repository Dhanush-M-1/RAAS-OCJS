#include <math.h>
#include <stdio.h>

#include <algorithm>
#include <iomanip>
#include <iostream>
#include <map>
#include <numeric>
#include <queue>
#include <set>
#include <stack>
#include <string>
#include <unordered_map>
#include <unordered_set>
#include <utility>
#include <vector>
using namespace std;
typedef long long int lld;
typedef long double llf;
typedef pair<int, int> pii;

const lld M = 1e9 + 7;
const int MAXN = 500002;

int n, m;
vector<int> adj[MAXN];

int padre[MAXN];

int raiz(int nodo) {
    if (padre[nodo] == -1) return nodo;
    return padre[nodo] = raiz(padre[nodo]);
}

int pot2(int e) {
    if (e == 0) return 1;
    lld x = pot2(e / 2);
    x *= x;
    x %= M;
    if (e & 1) x *= 2;
    return x % M;
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> m >> n;
    fill(padre, padre + n + 1, -1);

    vector<int> li;

    for (int i = 0; i < m; ++i) {
        int k;
        cin >> k;
        int a, b;
        cin >> a;
        if (k == 1) b = 0;
        else cin >> b;

        // Para ver si es l.i. 
        // aplicamos MST
        int ra = raiz(a);
        int rb = raiz(b);
        if (ra == rb) continue; // el vector es l.d.
        padre[ra] = rb;
        li.push_back(i+1);
    }

    cout << pot2(li.size()) << " " << li.size() << "\n";

    for (int x : li)
        cout << x << " ";

    cout << "\n";
    
    return 0;
}