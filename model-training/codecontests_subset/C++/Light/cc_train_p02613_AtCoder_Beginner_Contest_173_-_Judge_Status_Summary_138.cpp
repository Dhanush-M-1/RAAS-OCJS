#include<iostream>
#include<map>
using namespace std;
int n;
string st;
map<string,int> mp;
int main() {
    scanf("%d",&n);
    for(int i=1;i<=n;i++)
        cin>>st,mp[st]++;
    printf("AC x %d\nWA x %d\nTLE x %d\nRE x %d\n",mp["AC"],mp["WA"],mp["TLE"],mp["RE"]);
}