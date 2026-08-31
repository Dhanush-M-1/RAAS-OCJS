#include<bits/stdc++.h>
using namespace std;
int main()
{
    int tc;cin>>tc;
    map<string,int> mp;
    while(tc--)
    {

        string s;cin>>s;
        mp[s]++;
    }
    cout<<"AC x "<<mp["AC"]<<endl;
    cout<<"WA x "<<mp["WA"]<<endl;
    cout<<"TLE x "<<mp["TLE"]<<endl;
    cout<<"RE x "<<mp["RE"]<<endl;


}
