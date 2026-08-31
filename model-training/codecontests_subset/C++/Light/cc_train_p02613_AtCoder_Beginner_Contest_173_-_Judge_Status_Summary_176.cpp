#include<iostream>
#include<map>
using namespace std;
map<string,int> M;
int main() {
    string s;
    int n;
    cin >> n;
    while(n--) {
        cin >> s;
        ++M[s];
    }
    printf("AC x %d\nWA x %d\nTLE x %d\nRE x %d\n",M["AC"],M["WA"],M["TLE"],M["RE"]);
return 0;
}