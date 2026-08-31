#include <bits/stdc++.h>

using namespace std;

int main()
{
    long n;
    string s;
    string arr[4]={"AC","WA","TLE","RE"};
    map<string,int>m;
    cin>>n;
    for(int i=0;i<n;i++){
    cin>>s;
    m[s]++;
    }
    for(int i=0;i<4;i++){
    cout<<arr[i]<<" x "<<m[arr[i]]<<endl;
    }
    return 0;
}
