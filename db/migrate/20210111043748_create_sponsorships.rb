class CreateSponsorships < ActiveRecord::Migration[6.0]
  def change
    create_table :sponsorships do |t|
      t.string :name
      t.string :team_id
      t.string :contract_start
      t.string :contract_end

      t.timestamps
    end
  end
end
