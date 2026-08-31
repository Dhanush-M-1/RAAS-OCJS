#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
#include <numeric>
using namespace std;

int main(void) {
    int n;
    cin >> n;
    bool c[52];
    for(int i=0; i<52; i++)c[i]=false;
    for (int i=0;i<n;i++){
        char a;
        int b;
        cin >> a >> b;
        c[b-1+((a=='H')?13:0)+((a=='C')?26:0)+((a=='D')?39:0)] = true;
    }
    for(int i=0; i<52; i++){
        char d[4] = {'S','H','C','D'};
        if (!c[i]) {
            cout << d[i/13] << " " << (i%13+1) << endl;
        }
    }
    return 0;
}