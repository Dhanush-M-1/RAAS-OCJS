#include <bits/stdc++.h>
using namespace std;
typedef long long ll;


int main()
{
map<string,int>m;
int n;string s;cin>>n;
while(n--){
    cin>>s;m[s]++;
}
printf("AC x %d\n",m["AC"]);
printf("WA x %d\n",m["WA"]);
printf("TLE x %d\n",m["TLE"]);
printf("RE x %d\n",m["RE"]);


}
