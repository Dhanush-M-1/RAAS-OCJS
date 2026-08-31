#include <iostream>
#include <sstream>
#include <iomanip>
#include <algorithm>
#include <cmath>
#include <string>
#include <vector>
#include <list>
#include <queue>
#include <stack>
#include <set>
#include <map>
#include <bitset>
#include <numeric>
#include <climits>
#include <cfloat>
using namespace std;

int main()
{
    for(;;){
        int n;
        cin >> n;
        if(n == 0)
            return 0;

        vector<int> a(n);
        for(int i=0; i<n; ++i)
            cin >> a[i];

        int ret = 0;
        for(int i=0; i<n; ++i){
            for(int j=i+1; j<n; ++j){
                if(a[i] > a[j])
                    ++ ret;
            }
        }
        cout << ret << endl;
    }
}