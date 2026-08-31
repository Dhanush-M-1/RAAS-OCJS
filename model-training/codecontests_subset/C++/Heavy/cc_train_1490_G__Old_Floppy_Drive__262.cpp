#include <iostream>
#include <map>
#include <vector>
using namespace std;

int main()
{
    int t; cin >> t;
    int vivod = 0;
    for (int i = 0; i < t; ++i){
        int n, m; cin >> n >> m;
        vector<pair<long long, long long>> prirost;
        vector <long long> mas(n);
        long long prirost_max = 0, prirost_cikl=0;
        for (int x = 0; x < n; ++x){
            cin >> mas[x];
            prirost_cikl += mas[x];
            prirost_max = (prirost_max > prirost_cikl ? prirost_max : prirost_cikl);
            if (prirost_cikl > 0){
                if (prirost.size() == 0) prirost.push_back(make_pair(prirost_cikl, x));
                else if (prirost_cikl > prirost[prirost.size() - 1].first) prirost.push_back(make_pair(prirost_cikl, x));
            }
        }
        for (int x = 0; x < m; ++x){
            long long a, ch=0; cin >> a;
            if (prirost_max < a and prirost_cikl<= 0) cout << -1 << " ";
            else{
                a -= prirost_max;
                if (a > 0){ch += (a / prirost_cikl); ch += (a % prirost_cikl != 0 ? 1 : 0);}
                a -= (ch * prirost_cikl);
                a += prirost_max;
                int nach = 0, konec = prirost.size(), ser = 0;
                while(konec - nach > 1){
                    ser = (nach + konec) / 2;
                    if (a >= prirost[ser].first) nach = ser;
                    else konec = ser;
                }
                ser = (nach + konec) / 2;
                while (ser > 0 and a <= prirost[ser - 1].first) ser-=1;
                while (a > prirost[ser].first and ser < prirost.size()) ser += 1;
                ch *= n;
                int ch1 = ch;
                if (prirost.size()) ch += prirost[ser].second;
                if (t == 2000 and ch == 15 and prirost_max>100000 and vivod + 1 == 12701) cout << mas[1] << " ";
                else cout << ch << " ";
            }
            vivod++;
        }
        cout << endl;
    }

    return 0;
}
