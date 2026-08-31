#define _USE_MATH_DEFINES
#include <cstdio>
#include <iostream>
#include <sstream>
#include <fstream>
#include <iomanip>
#include <algorithm>
#include <cmath>
#include <complex>
#include <string>
#include <vector>
#include <list>
#include <queue>
#include <stack>
#include <set>
#include <map>
#include <bitset>
#include <numeric>
#include <limits>
#include <climits>
#include <cfloat>
#include <functional>
#include <iterator>
using namespace std;

int main()
{
    int n;
    cin >> n;

    set<int> s;
    for(int i=0; i<n; ++i){
        int a, b;
        cin >> a >> b;
        a += b;

        while(s.find(a) != s.end()){
            s.erase(a);
            ++ a;
        }
        s.insert(a);
    }

    for(int x : s)
        cout << x << " 0" << endl;

    return 0;
}