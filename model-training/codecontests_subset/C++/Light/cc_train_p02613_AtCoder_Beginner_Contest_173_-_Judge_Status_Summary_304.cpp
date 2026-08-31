#include <iostream>
#include <map>

using namespace std;

int n,i;
string s;
map <string,int> mp;

int main() 
{
    cin>>n;
    while (n--){
        cin>>s;
        mp[s]++;
    }
    cout<<"AC x "<<mp["AC"]<<endl;
    cout<<"WA x "<<mp["WA"]<<endl;
    cout<<"TLE x "<<mp["TLE"]<<endl;
    cout<<"RE x "<<mp["RE"];
}